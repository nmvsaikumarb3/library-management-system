import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class FetchBooks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		ConnectionDB c=new ConnectionDB();
		HashSet<String> bookNames=new HashSet<>();
		con=c.get_Connection();
		try {
			st=con.prepareStatement("select BookName from Books");  
			rs=st.executeQuery();
			while(rs.next()) {
				bookNames.add(rs.getString(1));
			}
			List<String> list = new ArrayList<String>(bookNames);
	        Collections.sort(list);
			for(String bname:list) {
				System.out.println(bname);
				
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
