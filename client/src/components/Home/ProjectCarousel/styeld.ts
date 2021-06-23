import styled from '@emotion/styled';

export const ProjectItem = styled.div`
  height: 700px;
  color: #fff;
  line-height: 160px;
  text-align: center;
  background: #364d79;
  h1 {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    color: #fff;
    font-weight: bold;
    font-size: 10rem;
    width: 100%;
  }
  h2 {
    position: absolute;
    top: 70%;
    left: 50%;
    transform: translate(-50%, -50%);
    color: #fff;
    font-weight: bold;
    font-size: 4rem;
    width: 100%;
  }
  img {
    width: 100%;
    height: 100%;
    object-fit: cover;
    object-position: bottom;
  }
  button {
    position: absolute;
    bottom: 10%;
    left: 50%;
    transform: translate(-50%, 0%);
    font-size: 2rem;
    height: auto;
  }
`;

export const SiteLayoutBackground = styled.div`
  background: #fff;
`;
