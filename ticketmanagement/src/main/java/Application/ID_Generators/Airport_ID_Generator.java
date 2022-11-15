package Application.ID_Generators;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class Airport_ID_Generator implements IdentifierGenerator {
	private String prefix = "AIRP";

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		Connection connection = session.connection();
		try 
		{
			Statement statement = connection.createStatement();
			String query = "SELECT Airport_ID FROM airport ORDER BY Airport_ID DESC LIMIT 1";
            ResultSet rs = statement.executeQuery(query);
            rs.next();
            String lastId = rs.getString("Airport_ID");
            int count = Integer.parseInt(lastId.replaceAll("[^0-9]", ""));
            return prefix + (String.format("%06d", count + 1));
        } 
		catch (SQLException e) 
		{
            e.printStackTrace();
        }
		
		return null;
	}
}
