package com.futou.cpad.userCenter.businessService.user.service;

import com.futou.cpcad.common.utils.id.UuidUtil;
import com.futou.cpcad.core.util.ResponseData;
import com.futou.cpcad.service.redis.util.RedisUtil;
import com.google.code.kaptcha.Producer;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.misc.BASE64Encoder;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

import static com.futou.cpcad.core.util.ResponseData.fail;
import static com.futou.cpcad.core.util.ResponseData.ok;
import static java.util.concurrent.TimeUnit.MINUTES;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.slf4j.LoggerFactory.getLogger;

@Transactional
@Service
public class ValidationCodeService {

  private final Logger logger = getLogger(getClass());

  @Resource
  private Producer captchaProducer;

  @Resource
  private RedisUtil redisUtil;

  public Map<String, String> createBase64Image() {
    String captcha = captchaProducer.createText();
    String base64Png = null;
    String png = null;
    Map<String, String> captchaObj = null;

    try (
        ByteArrayOutputStream baos = new ByteArrayOutputStream()
    ) {
      BufferedImage image = captchaProducer.createImage(captcha);
      ImageIO.write(image, "png", baos);
      BASE64Encoder base64Encoder = new BASE64Encoder();
      base64Png = base64Encoder.encodeBuffer(baos.toByteArray()).trim();
      png = base64Png.replaceAll("\n", "").replaceAll("\r", "");
      String pngId = "img-" + UuidUtil.getUuid();
      captchaObj = new HashMap<>(4);
      captchaObj.put("png", "data:image/png;base64," + png);
      captchaObj.put("pid", pngId);

      boolean result = redisUtil.set(pngId, captcha, 5, MINUTES);
      if (!result) {
        logger.error("{} pid={} captcha={}",
            "Redis put validation code error:",
            pngId,
            captcha);
      }
    } catch (Exception e) {
      logger.error("{} base64Png={} png={} exception: {}",
          "Create image code error:",
          base64Png,
          png,
          e);
    }

    return captchaObj;
  }

  public ResponseData isCorrectImageCode(
      String pngId,
      String code
  ) {
    if (isBlank(pngId)) {
      return fail(10001005, "短信验证码必输");
    }

    if (isBlank(code)) {
      return fail(10001006, "短信验证码必输");
    }

    if (!code.equals(redisUtil.get(pngId))) {
      return fail(10001007, "验证码错误");
    }

    return ok();
  }

}
