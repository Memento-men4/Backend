package hyu_memento.memento_back.entity;

import hyu_memento.memento_back.type.Gender;
import hyu_memento.memento_back.type.MemberType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity()
@Table
@Getter
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_seq")
    private Long seq;

    private Long id;
    private String password;
    private String name;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private MemberType type;
    private String birtyDay;
    private String email;

    @OneToMany(mappedBy = "member")
    private List<Record> records = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Quiz> quizs = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<GamePlay> gamePlays = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Appliance> appliances = new ArrayList<>();


    @Builder
    public Member(Long id, String password, String name, String phoneNumber, Gender gender, MemberType type, String birtyDay, String email) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.type = type;
        this.birtyDay = birtyDay;
        this.email = email;
    }

//    public void changeUserName(String username) {
//        this.username = username;
//    }
}
