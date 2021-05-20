import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class AuthorName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		ConnectionDB c=new ConnectionDB();
		HashSet<String> authorName=new HashSet<>();
		con=c.get_Connection();
		try {
			System.out.println("Type Letter to get the Author Name Starts with that Letter:\n");
			String letter=scan.next();			
			st=con.prepareStatement("select Author from Books where Author like ?");  
			st.setString(1,letter+"%");  
			rs=st.executeQuery();
			while(rs.next()) {

				authorName.add(rs.getString(1));
			}
			List<String> list = new ArrayList<String>(authorName);
	        Collections.sort(list);
			for(String aname:list) {
				System.out.println(aname);
				
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		


	}

}
