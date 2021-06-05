import { Button, Card, List } from 'antd';
import { FC } from 'react';
import { Link } from 'react-router-dom';
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
    <>
      <List
        grid={{ gutter: 16, column: 3 }}
        dataSource={data}
        renderItem={(item) => (
          <Link to={`question/${item.id}`}>
            <List.Item>
              <Card title={item.title}>{item.contents}</Card>
            </List.Item>
          </Link>
        )}
      />
      <Button type="primary" shape="round">
        <Link to="question">Q & A 바로가기</Link>
      </Button>
    </>
  );
};

export default QuestionList;
