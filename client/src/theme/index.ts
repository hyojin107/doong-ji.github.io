const breakPoint = {
  HDPC: '1200px',
  PC: '980px',
  TABLET: '768px',
  MOBILE: '480px',
};

const theme = {
  BACKGROUND_COLOR: '#ffffff',
  PRIMARY_COLOR: '#19CE60',
  WARNING_COLOR: '#ff4d4f',
  DARK_BACKGROUND_GREY: '#eeeeee',

  BP: breakPoint,
};

export default theme;

export type ThemeType = typeof theme;
