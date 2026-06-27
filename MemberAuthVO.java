package org.zerock.ex00.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *create table  tbl_auth (
 *   rolename varchar(50) not null,
 *   uid varchar(50) not null
 * );
 *
 * alter table tbl_auth add constraint fk_auth
 *     foreign key (uid) references tbl_member(uid);
 */
@Data

@NoArgsConstructor
public class MemberAuthVO {

  private String roleName;

  private String uid;

  public MemberAuthVO(String uid, String roleName) {
    this.roleName = roleName;
    this.uid = uid;
  }
}
