import { VFC } from 'react';
import { Card, Col, Row } from 'antd';

const { Meta } = Card;
const userAbout = [
  {
    user_id: 1,
    part: '프론트',
    name: '전동준',
    thumbnail: 'http://lorempixel.com/150/150/cats/1/',
    introduce: '안녕하세요 프론트엔드에서 조금 하고 있는 전동준입니다',
    github: 'https://github.com/hootre',
    project: [1, 2],
    comment: [1, 2, 3, 4, 5],
  },
  {
    user_id: 2,
    part: '퍼블리셔',
    name: '김은혜',
    introduce: '안녕하세요 퍼블리셔에서 많이 하고 있는 김은혜입니다',
    thumbnail: 'http://lorempixel.com/150/150/cats/2/',
    github: 'https://github.com/hootre',
    project: [1, 2],
    comment: [1, 2, 3, 4, 5],
  },
  {
    user_id: 3,
    part: '백엔드',
    name: '송효진',
    introduce: '안녕하세요 백엔드에서 많이 하고 있는 송효진입니다',
    thumbnail: 'http://lorempixel.com/150/150/cats/3/',
    github: 'https://github.com/hootre',
    project: [1, 2],
    comment: [1, 2, 3, 4, 5],
  },
];
const AboutProject = [
  {
    project_id: 1,
    title: 'doongji-site',
    content: '둥지 팀이 모여서 처음 프로젝트로 만드는 둥지의 사이트입니다',
  },
  {
    project_id: 2,
    title: 'cola-map',
    content: '둥지 팀이 모여서 만든 토이프로젝트 콜라 맵~ 입니다.',
  },
];
const AboutComment = [
  {
    user_id: 1,
    comment_content: '이렇게 댓글을 구성하면 될까요',
    reg_date: new Date(),
  },
  {
    user_id: 2,
    comment_content: '피곤해요',
    reg_date: new Date(),
  },
  {
    user_id: 3,
    comment_content: '빨리 만들어야 하는데',
    reg_date: new Date(),
  },
  {
    user_id: 4,
    comment_content: '멋지고 효율좋게',
    reg_date: new Date(),
  },
];

const About: VFC = () => {
  console.log(AboutComment[1]);
  return (
    <>
      <div className="site-card-wrapper">
        <Row gutter={16}>
          {userAbout &&
            userAbout.map((item) => {
              return (
                <Col span={8} key={item.user_id}>
                  <Card hoverable style={{ width: 240 }} cover={<img alt="thumbnail" src={item.thumbnail} />}>
                    <Meta title={item.name} description={item.introduce} />
                  </Card>
                </Col>
              );
            })}
        </Row>
      </div>
      {/* 
      About
      - 모든 팀원 자기소개 리스트
      멤버 detail
      - 활동중에 참여한 프로젝트 리스트
        -> 클릭시 Project 게시판 해당 프로젝트로 이동
       */}
    </>
  );
};

export default About;
