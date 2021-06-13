import { Content } from 'antd/lib/layout/layout';
import HomeMain from '@/components/Home/HomeMain';
import ProjectCarousel from '@/components/Home/ProjectCarousel';
import PartAbout from '@/components/Home/PartAbout';
import QuestionList from '@/components/Home/QuestionList';
import DoongjiJoin from '@/components/Home/DoongjiJoin';
import { FC } from 'react';
import styled from '@emotion/styled';

const Home: FC = () => {
  return (
    <>
      <Content className="site-layout" style={{ padding: '0 50px' }}>
        <SiteLayoutBackground style={{ padding: 24, minHeight: 380 }}>
          <HomeMain />
        </SiteLayoutBackground>
      </Content>

      <Content className="site-layout" style={{ padding: '0 50px', marginTop: 64 }}>
        <SiteLayoutBackground style={{ padding: 24, minHeight: 380 }}>
          <ProjectCarousel />
        </SiteLayoutBackground>
      </Content>

      <Content className="site-layout" style={{ padding: '0 50px', marginTop: 64 }}>
        <SiteLayoutBackground style={{ padding: 24, minHeight: 380 }}>
          <PartAbout />
        </SiteLayoutBackground>
      </Content>

      <Content className="site-layout" style={{ padding: '0 50px', marginTop: 64 }}>
        <SiteLayoutBackground style={{ padding: 24, minHeight: 380 }}>
          <QuestionList />
        </SiteLayoutBackground>
      </Content>

      <Content className="site-layout" style={{ padding: '0 50px', marginTop: 64 }}>
        <SiteLayoutBackground style={{ padding: 24, minHeight: 380 }}>
          <DoongjiJoin />
        </SiteLayoutBackground>
      </Content>
      {/* 
        1. 페럴록스 시작
        2. Project 리스트 슬라이드
        3. 파트소개 리스트 슬라이드
        4. Q & A  리스트 3개정도 나오고 링크
        5. Footer 둥지 참여하기 페럴록스
        6. ㄹㅇ Footer
      API 사용
      - Project List
      - 파트소개 (파트장)
      - Q & A 게시글목록

       */}
    </>
  );
};
const SiteLayoutBackground = styled.div`
  background: #fff;
`;
export default Home;
