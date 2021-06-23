import { FC, useState } from 'react';
import { Menu } from 'antd';

import { Content } from 'antd/lib/layout/layout';
import { SiteLayoutBackground } from './styeld';
const { SubMenu } = Menu;

// submenu keys of first level
const rootSubmenuKeys = ['sub1', 'sub2', 'sub4'];

const data = [
  {
    id: '1',
    part: '퍼블리싱 팀',
    contents: '웹표준과 웹접근성에 맞춰 프로젝트의 마크업을 주도합니다',
  },
  {
    id: '2',
    part: '프론트엔드 팀',
    contents: '퍼블리싱한 내용을 바탕으로 API를 웹페이지에 적용하고 백엔드와 연동시켜 실제 작동이 가능하도록 합니다',
  },
  {
    id: '3',
    part: '백엔드 팀 - Spring',
    contents: 'Spring 프레임워크를 사용하여 사이트에서 사용하는 전반적인 데이터를 제공합니다',
  },
  {
    id: '4',
    part: '백엔드 팀 - Node.js',
    contents: 'Node.js를 사용하여 데이터를 구성합니다',
  },
];
const PartAbout: FC = () => {
  const [openKeys, setOpenKeys] = useState(['sub1']);

  console.log(openKeys);
  const onOpenChange = (keys: any[]) => {
    const latestOpenKey = keys.find((key: string) => openKeys.indexOf(key) === -1);
    if (rootSubmenuKeys.indexOf(latestOpenKey) === -1) {
      setOpenKeys(keys);
    } else {
      setOpenKeys(latestOpenKey ? [latestOpenKey] : []);
    }
  };
  return (
    <Content className="site-layout" style={{ padding: '0 50px' }}>
      <SiteLayoutBackground style={{ padding: 24, minHeight: 380 }}>
        <Menu mode="inline" openKeys={openKeys} onOpenChange={onOpenChange} style={{ width: 256 }}>
          {data &&
            data.map((item, index) => {
              return (
                <SubMenu key={`sub${index + 1}`} title={item.part}>
                  <Menu.Item key="1">{item.contents}</Menu.Item>
                </SubMenu>
              );
            })}
        </Menu>
      </SiteLayoutBackground>
    </Content>
  );
};

export default PartAbout;
