package member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {
	private String id;
	private String passwd;
	private String name;
	private String email;
	private String responsibility;
	private String title;
	private String start_date;
	private String end_date;
	
}
