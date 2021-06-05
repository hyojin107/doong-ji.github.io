import { Card, List } from 'antd';
import { Meta } from 'antd/lib/list/Item';
import { FC } from 'react';
import { Link } from 'react-router-dom';

const data = [
  {
    id: '1',
    part: '프론트엔드',
    partRep: '이경민',
    partRepThumbnail: 'http://lorempixel.com/400/500/cats/1/',
    contents:
      '안녕하세요 둥지 프론트엔드 팀을 맞고 있는 XXX입니다 저희 둥지 프론트엔드팀은 4명을 시작해서 지금까지 2개의 프로젝트를 진행중에 있고 인원이 더 필요한 상황입니다 프론트엔드 여러분이 필요해요 !!',
  },
  {
    id: '2',
    part: '백엔드',
    partRep: '송효진',
    partRepThumbnail: 'http://lorempixel.com/400/500/cats/2/',
    contents:
      '안녕하세요 둥지 백엔드 팀을 맞고 있는 XXX입니다 저희 둥지 백엔드팀은 XX명을 시작해서 지금까지 X개의 프로젝트를 진행중에 있고 인원이 더 필요한 상황입니다 백엔드 여러분이 필요해요 !!',
  },
  {
    id: '3',
    part: '퍼블리싱',
    partRep: '김은혜',
    partRepThumbnail: 'http://lorempixel.com/400/500/cats/3/',
    contents:
      '안녕하세요 둥지 퍼블리싱 팀을 맞고 있는 XXX입니다 저희 둥지 퍼블리싱팀은 X명을 시작해서 지금까지 X개의 프로젝트를 진행중에 있고 인원이 더 필요한 상황입니다 퍼블리싱 여러분이 필요해요 !!',
  },
];
const PartAbout: FC = () => {
  return (
    <>
      <List
        grid={{ gutter: 16, column: 3 }}
        dataSource={data}
        renderItem={(item) => (
          <List.Item>
            <Link to={`about/${item.id}`}>
              <Card hoverable style={{ width: 400 }} cover={<img alt="thumbnail" src={item.partRepThumbnail} />}>
                <Meta title={`${item.part}/${item.partRep}`} description={item.contents} />
              </Card>
            </Link>
          </List.Item>
        )}
      />
    </>
  );
};

export default PartAbout;
