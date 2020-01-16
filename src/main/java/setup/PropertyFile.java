package setup;

public enum PropertyFile {

    WEB("web.properties"),
    NATIVE("native.properties");

    String appType;

    PropertyFile(String appType) {
        this.appType = appType;
    }

    public String getFileType() {
        return this.appType;
    }
}
