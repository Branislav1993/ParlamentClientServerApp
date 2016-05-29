package rs.silab.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import rs.silab.util.Util;

public class Member extends AbstractObject {

    private Integer id;
    private String name;
    private String lastName;
    private Date dateOfBirth;
    // pol: 0 muski, 1 zenski
    private Integer gender;
    private String email;
    private String biography;
    private Town placeOfBirth;
    private Town placeOfResidence;

    public Member() {

    }

    public Member(Integer id) {
        this.id = id;
    }

    public Member(Integer id, String name, String lastName, Date dateOfBirth, Integer gender, String email, String biography, Town placeOfBirth, Town placeOfResidence) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.email = email;
        this.biography = biography;
        this.placeOfBirth = placeOfBirth;
        this.placeOfResidence = placeOfResidence;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Town getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(Town placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public Town getPlaceOfResidence() {
        return placeOfResidence;
    }

    public void setPlaceOfResidence(Town placeOfResidence) {
        this.placeOfResidence = placeOfResidence;
    }

    @Override
    public String toString() {
        return "Member [memberID=" + id + ", name=" + name + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth
                + ", gender=" + gender + ", email=" + email + ", biography=" + biography + ", placeOfBirth="
                + placeOfBirth + ", placeOfResidence=" + placeOfResidence + "]";
    }

    @Override
    public String getTableName() {
        return "poslanik";
    }

    @Override
    public String getParameters() {
        return String.format("'%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s'", name, lastName, Util.SDF.format(dateOfBirth), gender, email, biography, placeOfBirth.getId(), placeOfResidence.getId());
    }

    @Override
    public String getPrimaryKeyName() {
        return "idposlanik";
    }

    @Override
    public Integer getPrimaryKeyValue() {
        return id;
    }

    @Override
    public List<AbstractObject> convertFromResultSetToList(ResultSet rs) {
        List<AbstractObject> members = new ArrayList<>();
        try {
            while (rs.next()) {

                Integer id = rs.getInt("idposlanik");
                String name = rs.getString("ime");
                String lastName = rs.getString("prezime");
                Date dateOfBirth = rs.getDate("datumrodjenja");
                Integer gender = rs.getInt("pol");
                String email = rs.getString("email");
                String biography = rs.getString("biografija");
                Integer placeOfBirthId = rs.getInt("idmestarodjenja");
                Integer placeOfResidenceId = rs.getInt("idmestaprebivalista");
                Member m = new Member(id, name, lastName, dateOfBirth, gender, email, biography, new Town(placeOfBirthId, null), new Town(placeOfResidenceId, null));
                members.add(m);
            }
        } catch (SQLException ex) {
            System.out.println("Error in convertFromResultSetToList Member.class");
        }
        return members;
    }

    @Override
    public String getUpdateQuery() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return "ime='" + name + "',prezime='" + lastName + "',datumrodjenja='" + sdf.format(dateOfBirth) + "',pol=" + gender + ",email='" + email + "',biografija='" + biography + "',idmestarodjenja=" + placeOfBirth.getId() + ",idmestaprebivalista=" + placeOfResidence.getId();
    }

    @Override
    public String getParameterNames() {
        return "ime,prezime,datumrodjenja,pol,email,biografija,idmestarodjenja,idmestaprebivalista";
    }

    @Override
    public String getComplexPrimaryKey() {
        return null;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Member other = (Member) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
