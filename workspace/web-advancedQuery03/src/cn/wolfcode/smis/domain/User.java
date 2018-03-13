package cn.wolfcode.smis.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter  @NoArgsConstructor @AllArgsConstructor @ToString
public class User {
	private Long id;
	private String name;
	private Integer age;
}
