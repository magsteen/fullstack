let uid = 0;

export default function NewUID() {
  const getID = () => {
    uid++;
    return uid;
  };

  return {
    getID,
  };
}
