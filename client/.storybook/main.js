const path = require('path');

const resolvePathFromRoot = (...pathSegments) => path.resolve(__dirname, '..', ...pathSegments);

module.exports = {
  stories: ['../src/**/*.stories.mdx', '../src/**/*.stories.@(js|jsx|ts|tsx)'],
  addons: [
    '@storybook/addon-links',
    '@storybook/addon-essentials',
    '@storybook/addon-actions',
    '@storybook/addon-knobs',
    '@storybook/preset-create-react-app',
  ],
  webpackFinal: async (config, { configType }) => {
    config.resolve.alias = {
      ...config.resolve.alias,
      '@': resolvePathFromRoot('src'),
      '@utils': resolvePathFromRoot('src', 'utils'),
      '@store': resolvePathFromRoot('src', 'store'),
      '@components': resolvePathFromRoot('src', 'components'),
      '@pages': resolvePathFromRoot('src', 'components', 'pages'),
    };
    return config;
  },
};
