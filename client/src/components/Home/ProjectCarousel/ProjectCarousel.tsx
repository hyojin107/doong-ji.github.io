import { Button, Carousel } from 'antd';
import { Content } from 'antd/lib/layout/layout';
import { FC } from 'react';
import { Link } from 'react-router-dom';
import { ProjectItem, SiteLayoutBackground } from './styeld';

const data = [
  {
    id: '1',
    title: '둥지 홈페이지',
    coment: '당신의 개발실력을 늘려보세요 ~!',
    period: '2021-04 - 2021-08',
    Thumbnail: 'http://lorempixel.com/1500/900/cats/1/',
  },
  {
    id: '2',
    title: '콜라 맵',
    coment: '콜라 vs 펩시 당신의 선택은 ?',
    period: '2021-04 - 2021-08',
    Thumbnail: 'http://lorempixel.com/1500/900/cats/2/',
  },
  {
    id: '3',
    title: '둥카오톡',
    coment: '카카오톡 오늘도 울리는군요',
    period: '2021-04 - 2021-08',
    Thumbnail: 'http://lorempixel.com/1500/900/cats/3/',
  },
];
const ProjectCarousel: FC = () => {
  return (
    <Content className="site-layout" style={{ padding: '0 50px' }}>
      <SiteLayoutBackground style={{ padding: 24, minHeight: 380 }}>
        <Carousel effect="fade">
          {data.map((item) => {
            return (
              <div key={item.id}>
                <ProjectItem>
                  <h1>{item.title}</h1>
                  <h2>{item.coment}</h2>
                  <img src={item.Thumbnail} />
                  <Button type="primary" shape="round">
                    <Link to={`project/${item.id}`}>바로가기</Link>
                  </Button>
                </ProjectItem>
              </div>
            );
          })}
        </Carousel>
      </SiteLayoutBackground>
    </Content>
  );
};
export default ProjectCarousel;
