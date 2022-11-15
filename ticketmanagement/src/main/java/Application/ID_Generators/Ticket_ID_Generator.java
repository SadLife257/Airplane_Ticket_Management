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

public class Ticket_ID_Generator implements IdentifierGenerator{
	private String prefix = "TCKT";

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		Connection connection = session.connection();
		try 
		{
			Statement statement = connection.createStatement();
			String query = "SELECT Ticket_Number FROM ticket ORDER BY Ticket_Number DESC LIMIT 1";
            ResultSet rs = statement.executeQuery(query);
            rs.next();
            String lastId = rs.getString("Ticket_Number");
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
