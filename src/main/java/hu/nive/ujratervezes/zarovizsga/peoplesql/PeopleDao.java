package hu.nive.ujratervezes.zarovizsga.peoplesql;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PeopleDao {

    DataSource dataSource;

    public PeopleDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String findIpByName(String firstName, String lastName) {
        try (Connection cnx = dataSource.getConnection();
             PreparedStatement pstmt = cnx.prepareStatement("select ip_address from people where first_name = ? and last_name=?")) {
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            return getStringFromResultSet(pstmt);
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot connect database", se);
        }
    }

    private String getStringFromResultSet(PreparedStatement pstmt) throws SQLException {
        try (ResultSet rs = pstmt.executeQuery()) {
            if(rs.next()) {
                return rs.getString("ip_address");
            }
            throw new IllegalArgumentException("Cannot find ip address");

        }
    }

}
