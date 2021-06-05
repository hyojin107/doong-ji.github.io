import styled from '@emotion/styled';
import { Button, Card, Carousel, List } from 'antd';
import { Meta } from 'antd/lib/list/Item';
import { FC } from 'react';
import { Link } from 'react-router-dom';

const data = [
  {
    id: '1',
    title: '둥지 홈페이지',
    period: '2021-04 - 2021-08',
    Thumbnail: 'http://lorempixel.com/1500/900/cats/1/',
  },
  {
    id: '2',
    title: '콜라 맵',
    period: '2021-04 - 2021-08',
    Thumbnail: 'http://lorempixel.com/1500/900/cats/2/',
  },
  {
    id: '3',
    title: '둥카오톡',
    period: '2021-04 - 2021-08',
    Thumbnail: 'http://lorempixel.com/1500/900/cats/3/',
  },
];
const ProjectCarousel: FC = () => {
  return (
    <>
      {/* <List
          grid={{ gutter: 16, column: 3 }}
          dataSource={data}
          renderItem={(item) => (
              <List.Item>
                <Link to={`project/${item.id}`}>
                  <Card hoverable style={{ width: 400 }} cover={<img alt="thumbnail" src={item.Thumbnail} />}>
                    <Meta title={`${item.title}`} description={item.period} />
                  </Card>
                </Link>
              </List.Item>
          )}
        /> */}
      <Carousel effect="fade">
        {data.map((item) => {
          return (
            <div key={item.id}>
              <ProjectItem>
                <h1>{item.title}</h1>
                <img src={item.Thumbnail} />
                <Button type="primary" shape="round">
                  <Link to={`project/${item.id}`}>바로가기</Link>
                </Button>
              </ProjectItem>
            </div>
          );
        })}
      </Carousel>
    </>
  );
};
const ProjectItem = styled.div`
  height: 700px;
  color: #fff;
  line-height: 160px;
  text-align: center;
  background: #364d79;
  h1 {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    color: #fff;
    font-weight: bold;
    font-size: 10rem;
    width: 100%;
  }
  img {
    width: 100%;
    height: 100%;
    object-fit: cover;
    object-position: bottom;
  }
  button {
    position: absolute;
    bottom: 10%;
    left: 50%;
    transform: translate(-50%, 0%);
    font-size: 2rem;
    height: auto;
  }
`;
export default ProjectCarousel;
