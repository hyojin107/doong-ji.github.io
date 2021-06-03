interface RegExpDictionary {
  [key: string]: RegExp;
}

const signupExp: RegExpDictionary = {
  name: /^[가-힣]{2,5}$/,
  email: /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i,
  password: /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/,
  nickname: /^[가-힣]{2,5}$/,
};

export const isName = (expName: string): boolean => {
  return signupExp.name.test(expName);
};

export const isEmail = (expEmail: string): boolean => {
  return signupExp.email.test(expEmail);
};

export const isPassword = (expPassword: string): boolean => {
  return signupExp.password.test(expPassword);
};

export const isNickname = (expNickname: string): boolean => {
  return signupExp.nickname.test(expNickname);
};
