import HomeMain from '@/components/Home/HomeMain';
import DoongjiAbout from '@/components/Home/DoongjiAbout';
import ProjectCarousel from '@/components/Home/ProjectCarousel';
import PartAbout from '@/components/Home/PartAbout';
import QuestionList from '@/components/Home/QuestionList';
import DoongjiJoin from '@/components/Home/DoongjiJoin';

import { FC } from 'react';
const Home: FC = () => {
  return (
    <>
      <HomeMain />
      <DoongjiAbout />
      <ProjectCarousel />
      <PartAbout />
      <QuestionList />
      <DoongjiJoin />
    </>
  );
};

export default Home;
