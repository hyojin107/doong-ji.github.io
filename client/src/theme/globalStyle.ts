import { css } from '@emotion/react';
import reset from 'emotion-reset';

const GlobalStyle = css`
  ${reset}

  body {
    font-family: 'Noto Sans KR', sans-serif;
    font-size: 14px;
    height: 100%;
  }
  html {
    height: 100%;
  }
  .ant-carousel .slick-dots li button {
    height: 13px;
  }
`;

export default GlobalStyle;
