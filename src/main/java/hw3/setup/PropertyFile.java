package hw3.setup;

public enum PropertyFile {

    WEB("web.properties"),
    NATIVE("native.properties"),
    IOS_NATIVE("nativeIos.properties"),
    IOS_WEB("webIos.properties");

    String appType;

    PropertyFile(String appType) {
        this.appType = appType;
    }

    public String getFileType() {
        return this.appType;
    }
}
