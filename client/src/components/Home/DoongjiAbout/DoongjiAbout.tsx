import { FC } from 'react';
import { Content } from 'antd/lib/layout/layout';
import { SiteLayoutBackground } from './styeld';
const DoongjiAbout: FC = () => {
  return (
    <Content className="site-layout" style={{ padding: '0 50px' }}>
      <SiteLayoutBackground style={{ padding: 24, minHeight: 380 }}>
        <span>DoongjiAbout</span>
      </SiteLayoutBackground>
    </Content>
  );
};

export default DoongjiAbout;
