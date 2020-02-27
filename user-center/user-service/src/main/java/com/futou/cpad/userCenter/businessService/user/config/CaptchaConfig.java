package com.futou.cpad.userCenter.businessService.user.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

import static com.google.code.kaptcha.Constants.*;

@Configuration
public class CaptchaConfig {

  @Bean
  public DefaultKaptcha getDefaultKaptch() {
    DefaultKaptcha captcha = new DefaultKaptcha();
    Properties props = new Properties();
    props.setProperty(KAPTCHA_BORDER, "no");
    props.setProperty(KAPTCHA_BACKGROUND_CLR_FROM, "238,238,238");
    props.setProperty(KAPTCHA_BACKGROUND_CLR_TO, "238,238,238");
    props.setProperty(KAPTCHA_IMAGE_WIDTH, "150");
    props.setProperty(KAPTCHA_IMAGE_HEIGHT, "45");
    props.setProperty(KAPTCHA_SESSION_CONFIG_KEY, KAPTCHA_SESSION_KEY);
    props.setProperty(KAPTCHA_NOISE_IMPL, "com.google.code.kaptcha.impl.DefaultNoise");
    props.setProperty(KAPTCHA_NOISE_COLOR, "51,51,51");
    props.setProperty(KAPTCHA_TEXTPRODUCER_CHAR_STRING, "0123456789");
    props.setProperty(KAPTCHA_TEXTPRODUCER_CHAR_LENGTH, "4");
    props.setProperty(KAPTCHA_TEXTPRODUCER_CHAR_SPACE, "4");
    props.setProperty(KAPTCHA_TEXTPRODUCER_FONT_COLOR, "51,51,51");
    props.setProperty(KAPTCHA_TEXTPRODUCER_FONT_NAMES, "Arial, Courier");
    props.setProperty(KAPTCHA_TEXTPRODUCER_FONT_SIZE, "35");
    Config config = new Config(props);
    captcha.setConfig(config);
    return captcha;
  }

}
