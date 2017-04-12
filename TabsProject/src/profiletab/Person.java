package profiletab;

/**
 *
 * @author Michelle Marie Garcia
 * 
 * This class creates a Person object to hold a student's info input by the user.
 */
public class Person {
    private String lastName;
    private String firstName;
    private String id;
    private String email;
    private String webURL;

    /**
     * 
     * @param lastName
     * @param firstName
     * @param id 
     * 
     * A constructor with only a few entries
     */
    public Person(String lastName, String firstName, String id) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.id = id;
    }

    /**
     * 
     * @param lastName
     * @param firstName
     * @param id
     * @param email
     * @param webURL 
     * 
     * A constructor with all inputs given
     */
    public Person(String lastName, String firstName, String id, String email, String webURL) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.id = id;
        this.email = email;
        this.webURL = webURL;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the webURL
     */
    public String getWebURL() {
        return webURL;
    }

    /**
     * @param webURL the webURL to set
     */
    public void setWebURL(String webURL) {
        this.webURL = webURL;
    }
}