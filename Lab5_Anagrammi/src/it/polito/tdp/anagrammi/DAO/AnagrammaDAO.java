package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnagrammaDAO {

	public boolean dimmiSeCorretta(String a) {	

			final String sql = "SELECT nome FROM parola WHERE nome=?";		
			boolean result;
			
			try {
				Connection conn = ConnectDB.getConnection();
				PreparedStatement st = conn.prepareStatement(sql);

				st.setString(1, a);
				ResultSet rs = st.executeQuery();

				if (rs.next()) {
					result= true;			
					
				}
				else {
					result= false;
				}

				conn.close();
				
				

			} catch (SQLException e) {
				// e.printStackTrace();
				throw new RuntimeException("Errore Db");
			}		
		
		
		
		return result;
	}

}
