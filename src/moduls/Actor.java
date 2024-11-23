package moduls;

public class Actor {
    private Long id;
    private String actorFullName;
    private String role;

    public Actor(Long id, String actorFullName, String role) {
        this.id = id;
        this.actorFullName = actorFullName;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActorFullName() {
        return actorFullName;
    }

    public void setActorFullName(String actorFullName) {
        this.actorFullName = actorFullName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return
                "\nid=" + id +
                ", actorFullName='" + actorFullName + '\'' +
                ", role='" + role + '\'';
    }
}
