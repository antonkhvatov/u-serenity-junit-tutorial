package serenityswag.authentication;
/*standard_user
        locked_out_user
        problem_user
        performance_glitch_user
        error_user
        visual_user*/

public enum User {
    STANDARD_USER("standard_user", "secret_sauce", "a standard user"),
    LOCKED_OUT_USER("locked_out_user", "secret_sauce", "a standart user"),
    PROBLEM_USER("problem_user", "secret_sauce", "a standart user"),
    PERFORMANCE_GLITCH_USER("performance_glitch_user", "secret_sauce", "a standart user"),
    ERROR_USER("error_user", "secret_sauce", "a standart user"),
    VISUAL_USER("visual_user", "secret_sauce", "a standart user");
    private final String username;
    private final String password;
    private final String description;

    User(String username, String password, String description) {
        this.username = username;
        this.password = password;
        this.description = description;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return description;
    }
}
