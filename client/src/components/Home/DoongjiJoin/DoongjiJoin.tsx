import { Button } from 'antd';
import { SiteLayoutBackground } from './styeld';
import { FC } from 'react';

import { Content } from 'antd/lib/layout/layout';
import { Link } from 'react-router-dom';

const DoongjiJoin: FC = () => {
  return (
    <Content className="site-layout" style={{ padding: '0 50px' }}>
      <SiteLayoutBackground style={{ padding: 24, minHeight: 380 }}>
        <Button type="primary" shape="round">
          <Link to="signup">바로가기</Link>
        </Button>
      </SiteLayoutBackground>
    </Content>
  );
};
export default DoongjiJoin;
