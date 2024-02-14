package com.example;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomGenerator implements IdentifierGenerator {

	private static final long serialVersionUID = 1L;

	String prefix = "TCS";
	Integer value = 0;

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) {
		// TODO Auto-generated method stub

		try {
			Connection con = session.getJdbcConnectionAccess().obtainConnection();
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("select orderid from pk_val");

			if (rs.next()) {
				value = rs.getInt("orderid") + 1;
				stmt.executeUpdate("UPDATE  pk_val SET orderid=" + value);
			} else {
				value = 1;
				stmt.executeUpdate("insert into pk_val(orderid) values(" + value + ")");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return prefix + value;
	}

}
