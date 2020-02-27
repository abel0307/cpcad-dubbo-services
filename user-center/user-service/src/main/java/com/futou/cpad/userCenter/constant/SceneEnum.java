package com.futou.cpad.userCenter.constant;

public enum SceneEnum {

  WECHAT_LOGIN("WeChatLogin-", "扫码登录"),
  BIND_MOBILE("BindMobile-", "绑定手机号账号");

  private String scene;
  private String desc;

  SceneEnum(
      String scene,
      String desc
  ) {
    this.scene = scene;
    this.desc = desc;
  }

  public static SceneEnum find(String scene) {
    if (scene == null || "".equals(scene.trim())) {
      return null;
    }

    for (SceneEnum sceneEnum : SceneEnum.values()) {
      if (scene.startsWith(sceneEnum.getScene())) {
        return sceneEnum;
      }
    }

    return null;
  }

  public static String parseValue(String scene) {
    SceneEnum sceneEnum = find(scene);
    if (sceneEnum == null) {
      return scene;
    }

    return scene.substring(sceneEnum.getScene().length());
  }

  public static boolean containScene(String scene) {
    return find(scene) != null;
  }

  public String getScene() {
    return scene;
  }

  public String getDesc() {
    return desc;
  }
}
