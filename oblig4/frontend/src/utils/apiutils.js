export function doLogin(request) {
  if (request.username === "user" && request.password === "pass") {
    return { loginStatus: "Success" };
  } else {
    return { loginStatus: "Failed" };
  }
}

export function doRegister(request) {
  if (
    request.name !== "" &&
    request.username !== "" &&
    request.password !== ""
  ) {
    return { registerStatus: "Success" };
  } else {
    return { registerStatus: "Failed" };
  }
}
