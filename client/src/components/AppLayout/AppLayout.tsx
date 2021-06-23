import { Menu } from 'antd';
import Layout, { Footer, Header } from 'antd/lib/layout/layout';
import { FC, useCallback } from 'react';
import { Link } from 'react-router-dom';
import { animateScroll as scroll } from 'react-scroll';
import { Logo } from './styled';
const AppLayout: FC = ({ children }) => {
  const toggleHome = useCallback(() => {
    scroll.scrollToTop();
  }, []);
  return (
    <>
      <Layout>
        <Header
          style={{
            position: 'relative',
            zIndex: 1,
            width: '100%',
            transition: '0.8s all ease',
            marginBottom: '64px',
          }}
        >
          <Logo to="/" className="logo" onClick={toggleHome} />
          <Menu theme="dark" mode="horizontal">
            <Menu.Item key="1">
              <Link to="about">둥지소개</Link>
            </Menu.Item>
            <Menu.Item key="2">
              <Link to="notice">공지사항</Link>
            </Menu.Item>
            <Menu.SubMenu key="3" title={<Link to="community">커뮤니티</Link>}>
              <Menu.ItemGroup title="게시판">
                <Menu.Item key="setting:1">자유게시판</Menu.Item>
                <Menu.Item key="setting:2">질문게시판</Menu.Item>
                <Menu.Item key="setting:3">링크공유게시판</Menu.Item>
                <Menu.Item key="setting:4">프로젝트게시판</Menu.Item>
              </Menu.ItemGroup>
            </Menu.SubMenu>
            <Menu.SubMenu key="4" title={<Link to="project">프로젝트</Link>}>
              <Menu.ItemGroup title="프로젝트">
                <Menu.Item key="setting:1">진행중</Menu.Item>
                <Menu.Item key="setting:2">진행예정</Menu.Item>
                <Menu.Item key="setting:3">완료</Menu.Item>
              </Menu.ItemGroup>
            </Menu.SubMenu>
            <Menu.Item key="5">
              <Link to="calendar">캘린더</Link>
            </Menu.Item>
            <Menu.Item key="6">
              <Link to="question"> Q & A</Link>
            </Menu.Item>
            <Menu.Item key="7">
              <Link to="signup"> Sign up</Link>
            </Menu.Item>
            <Menu.Item key="8">
              <Link to="signin"> Sign in</Link>
            </Menu.Item>
          </Menu>
        </Header>
        {children}
        <Footer
          style={{
            marginTop: '64px',
          }}
        >
          Footer
        </Footer>
      </Layout>
    </>
  );
};

export default AppLayout;
