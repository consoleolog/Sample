package org.zerock.ex00.mappers;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.ex00.domain.Criteria;
import org.zerock.ex00.domain.ReplyVO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
public class ReplyMapperTests {

  @Autowired(required = false)
  private ReplyMapper replyMapper;

  @Test
  public void testInsert() {

    Long bno = 1524L;

    for (int i = 0; i < 32; i++) {

      ReplyVO replyVO = ReplyVO.builder()
              .bno(bno)
              .replyText("Sample Reply..."+i)
              .replyer("replyer1")
              .build();
      log.info(replyMapper.insert(replyVO));
    }
  }

  @Test
  public void testSelectOne() {

    log.info(replyMapper.selectOne(20L));

  }

  @Test
  public void testDeleteOne() {

    log.info(replyMapper.deleteOne(52L));

  }

  @Test
  public void testUpdateOne() {

    ReplyVO replyVO = ReplyVO.builder()
            .rno(51L)
            .replyText("Updated... 51 ")
            .build();

    log.info(replyMapper.updateOne(replyVO));
  }

  @Test
  public void testGetList() {

    //1, 10
    Criteria criteria = new Criteria();

    replyMapper.getList(criteria, 1524L).forEach(replyVO -> log.info(replyVO));

  }

  @Test
  public void testGetTotal() {

    Long bno = 156L;

    log.info(replyMapper.getTotal(null, bno));

  }

}
