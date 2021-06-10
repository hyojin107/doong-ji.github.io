import '@emotion/react';

interface IBreakPoint {
  HDPC: string;
  PC: string;
  TABLET: string;
  MOBILE: string;
}

declare module '@emotion/react' {
  export interface Theme {
    BACKGROUND_COLOR: string;
    PRIMARY_COLOR: string;
    WARNING_COLOR: string;
    DARK_BACKGROUND_GREY: string;
    BP: IBreakPoint;
  }
}
