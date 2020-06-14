package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "spring_cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "series")
    private Long series;

    @OneToOne(mappedBy = "car")
    private User user;

    public Car() {}

    public Car(String name, Long series) {
        this.name = name;
        this.series = series;
    }

    public Car(String name, Long series, User user) {
        this.name = name;
        this.series = series;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String firstName) {
        this.name = name;
    }

    public Long getSeries() {
        return series;
    }

    public void setSeries(Long series) {
        this.series = series;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}