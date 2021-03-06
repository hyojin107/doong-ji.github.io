import { createAsyncThunk, createSlice, PayloadAction } from '@reduxjs/toolkit';

import { RootState } from '@/store';
import { Movie, StatusType } from '@/types/movie';
import { Genre } from '@/apis';
import { fetchApi } from '@/utils/fetchApi';

interface GenreType {
  genre: Movie[];
  status: StatusType;
}

const initialState: GenreType = {
  genre: [],
  status: 'idle',
};

const fetGenre = fetchApi<Movie[]>({ url: Genre, method: 'GET' });

export const genreAsync = createAsyncThunk('genre/fetchGenre', async () => {
  const res = await fetGenre();
  return res;
});

//slice
export const genreSlice = createSlice({
  name: 'genre',
  initialState,
  reducers: {},

  extraReducers: (builder) => {
    builder
      .addCase(genreAsync.pending, (state) => {
        state.status = 'loading';
      })
      .addCase(genreAsync.fulfilled, (state, action: PayloadAction<Movie[]>) => {
        state.status = 'idle';
        state.genre = action.payload;
      })
      .addCase(genreAsync.rejected, (state, action) => {
        if (action.error.name === 'FailRequest') {
          //error 분기
        }
        state.status = 'failed';
      });
  },
});

export const getGenre = (state: RootState) => state.genre;

export default genreSlice.reducer;
