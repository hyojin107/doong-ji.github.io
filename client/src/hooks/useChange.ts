import { useState, useCallback, SetStateAction, Dispatch } from 'react';

const useChange = <T extends { value: string } = HTMLInputElement>(
  initialState: string,
): [string, (e: React.ChangeEvent<T>) => void, Dispatch<SetStateAction<string>>] => {
  const [value, setValue] = useState(initialState);

  const onChangeHandler = useCallback((e: React.ChangeEvent<T>) => {
    setValue(e.target.value);
  }, []);

  return [value, onChangeHandler, setValue];
};

export default useChange;
