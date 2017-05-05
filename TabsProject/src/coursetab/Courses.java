package coursetab;

/**
 *
 * @author Michelle Marie Garcia
 * 
 * This class creates a Courses object to hold courses input by the user.
 */
public class Courses {
    private String courseId;
    private String prefix;
    private String courseNum;
    private String section;
    private String startTime;
    private String endTime;
    private String location;
    private String instructor;
    private String prereq;

    /**
     * 
     * @param courseId
     * @param prefix
     * @param courseNum
     * @param section 
     * 
     * This constructor takes only certain fields
     */
    public Courses(String courseId, String prefix, String courseNum, String section) {
        this.courseId = courseId;
        this.prefix = prefix;
        this.courseNum = courseNum;
        this.section = section;
    }

    /**
     * 
     * @param courseId
     * @param prefix
     * @param courseNum
     * @param section
     * @param startTime
     * @param endTime
     * @param location
     * @param instructor
     * @param prereq 
     * 
     * This constructor takes all input
     */
    public Courses(String courseId, String prefix, String courseNum, String section, String startTime, String endTime, String location, String instructor, String prereq) {
        this.courseId = courseId;
        this.prefix = prefix;
        this.courseNum = courseNum;
        this.section = section;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
        this.instructor = instructor;
        this.prereq = prereq;
    }
    
    /**
     * @return the courseId
     */
    public String getCourseId() {
        return courseId;
    }

    /**
     * @param courseId the courseId to set
     */
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    /**
     * @return the prefix
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * @param prefix the prefix to set
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    /**
     * @return the courseNum
     */
    public String getCourseNum() {
        return courseNum;
    }

    /**
     * @param courseNum the courseNum to set
     */
    public void setCourseNum(String courseNum) {
        this.courseNum = courseNum;
    }

    /**
     * @return the section
     */
    public String getSection() {
        return section;
    }

    /**
     * @param section the section to set
     */
    public void setSection(String section) {
        this.section = section;
    }

    /**
     * @return the startTime
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * @param startTime the startTime to set
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * @return the endTime
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * @param endTime the endTime to set
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the instructor
     */
    public String getInstructor() {
        return instructor;
    }

    /**
     * @param instructor the instructor to set
     */
    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    /**
     * @return the prereq
     */
    public String getPrereq() {
        return prereq;
    }

    /**
     * @param prereq the prereq to set
     */
    public void setPrereq(String prereq) {
        this.prereq = prereq;
    }
}