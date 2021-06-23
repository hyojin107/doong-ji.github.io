import { Button, Card, List } from 'antd';
import { FC } from 'react';
import { Link } from 'react-router-dom';

import { Content } from 'antd/lib/layout/layout';
import { SiteLayoutBackground } from './styeld';
const data = [
  {
    id: '1',
    title: '제목도 필요없을 듯',
    contents: '일단은 핵심적인 내용만 구현할게요',
  },
  {
    id: '2',
    title: '필요할려나 퍼블분들꺼 봐야할듯해요',
    contents: '잘하고싶네용',
  },
  {
    id: '3',
    title: '호호호',
    contents: '최대한 빠르게 잘 해보겠습니다',
  },
];
const QuestionList: FC = () => {
  return (
    <Content className="site-layout" style={{ padding: '0 50px' }}>
      <SiteLayoutBackground style={{ padding: 24, minHeight: 380 }}>
        <List
          itemLayout="horizontal"
          dataSource={data}
          renderItem={(item) => (
            <List.Item>
              <List.Item.Meta title={<a href="https://ant.design">{item.title}</a>} description={item.contents} />
            </List.Item>
          )}
        />
        <Button type="primary" shape="round">
          <Link to="question">Q & A 바로가기</Link>
        </Button>
      </SiteLayoutBackground>
    </Content>
  );
};

export default QuestionList;
