package xyz.rk.bookshare.model;

public class Catalog {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column catalog.id
     *
     * @mbg.generated Mon Mar 25 13:14:37 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column catalog.name
     *
     * @mbg.generated Mon Mar 25 13:14:37 CST 2019
     */
    private String name;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column catalog.id
     *
     * @return the value of catalog.id
     *
     * @mbg.generated Mon Mar 25 13:14:37 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column catalog.id
     *
     * @param id the value for catalog.id
     *
     * @mbg.generated Mon Mar 25 13:14:37 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column catalog.name
     *
     * @return the value of catalog.name
     *
     * @mbg.generated Mon Mar 25 13:14:37 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column catalog.name
     *
     * @param name the value for catalog.name
     *
     * @mbg.generated Mon Mar 25 13:14:37 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}