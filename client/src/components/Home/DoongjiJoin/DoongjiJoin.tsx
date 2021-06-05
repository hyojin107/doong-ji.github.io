import styled from '@emotion/styled';
import { Button, Form, Input, InputNumber, Modal, Switch } from 'antd';
import { FC, useCallback, useState } from 'react';
import { Link } from 'react-router-dom';

const layout = {
  labelCol: { span: 8 },
  wrapperCol: { span: 16 },
};
const validateMessages = {
  required: '${label} is required!',
  types: {
    email: '${label} is not a valid email!',
    number: '${label} is not a valid number!',
  },
  number: {
    range: '${label} must be between ${min} and ${max}',
  },
};

const DoongjiJoin: FC = () => {
  const [isMember, setIsMember] = useState(true);
  const [isModalVisible, setIsModalVisible] = useState(false);

  const showModal = useCallback(() => {
    setIsModalVisible(true);
  }, [isModalVisible]);

  const handleOk = useCallback(() => {
    setIsModalVisible(false);
  }, [isModalVisible]);

  const handleCancel = useCallback(() => {
    setIsModalVisible(false);
  }, [isModalVisible]);

  const onChangeIsMember = useCallback(() => {
    setIsMember((prev) => !prev);
  }, [isMember]);

  const onFinish = (values: any) => {
    console.log(values);
  };
  return (
    <>
      <Switch defaultChecked onChange={onChangeIsMember} />
      {isMember ? (
        <IsMemberContent>
          <Button type="primary" onClick={showModal}>
            둥지 참여하기
          </Button>
          <Modal title="둥지 참여하기" visible={isModalVisible} onOk={handleOk} onCancel={handleCancel}>
            <Form {...layout} name="nest-messages" onFinish={onFinish} validateMessages={validateMessages}>
              <Form.Item name={['user', 'name']} label=" 이름" rules={[{ required: true }]}>
                <Input />
              </Form.Item>
              <Form.Item name={['user', 'email']} label="이메일" rules={[{ type: 'email', required: true }]}>
                <Input />
              </Form.Item>
              <Form.Item name={['user', 'age']} label="나이" rules={[{ type: 'number', min: 0, max: 99 }]}>
                <InputNumber />
              </Form.Item>
              <Form.Item name={['user', 'career']} label="경력">
                <Input />
              </Form.Item>
              <Form.Item name={['user', 'motive']} label="지원동기">
                <Input.TextArea />
              </Form.Item>
              <Form.Item wrapperCol={{ ...layout.wrapperCol, offset: 8 }}>
                <Button type="primary" htmlType="submit">
                  전송
                </Button>
              </Form.Item>
            </Form>
          </Modal>
        </IsMemberContent>
      ) : (
        <NonMemberContent>
          <span>이미 멤버시잖아요 !</span>
        </NonMemberContent>
      )}
    </>
  );
};
const IsMemberContent = styled.div`
  width: 100%;
  padding: 50px;
`;
const NonMemberContent = styled.div`
  width: 100%;
  padding: 50px;
`;
export default DoongjiJoin;
