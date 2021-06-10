import { useState, useCallback, SetStateAction, Dispatch } from 'react';

const useChange = <T extends { value: string } = HTMLInputElement>(
  initialState: string,
): [string, Dispatch<SetStateAction<string>>, (e: React.ChangeEvent<T>) => void] => {
  const [value, setValue] = useState(initialState);

  const onChangeHandler = useCallback((e: React.ChangeEvent<T>) => {
    setValue(e.target.value);
  }, []);

  return [value, setValue, onChangeHandler];
};

export default useChange;
