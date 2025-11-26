package services;

public class ActionResult {
    public boolean success;
    public String message;
    public Object value;

    public ActionResult(boolean success) {
        this.success = success;
    }

    public ActionResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ActionResult(boolean success, Object value) {
        this.success = success;
        this.value = value;
    }

    public ActionResult(boolean success, String message, Object value) {
        this.success = success;
        this.message = message;
        this.value = value;
    }
}
