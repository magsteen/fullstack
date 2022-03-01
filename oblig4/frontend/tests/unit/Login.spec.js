import { flushPromises, shallowMount } from "@vue/test-utils";
import LoginView from "@/views/LoginView.vue";
import store from "@/store/index.js";
import router from "@/router/index.js";

let wrapper;

describe("LoginComponent.vue", () => {
  beforeEach(() => {
    wrapper = shallowMount(LoginView, {
      global: {
        mocks: {
          $store: store,
          $router: router,
        },
      },
    });
  });

  it("check that LoginComponent renders", () => {
    const loginTitle = "Please login!";
    expect(wrapper.text()).toMatch(loginTitle);

    expect(wrapper.find("#loginstatusLabel").exists()).toBe(true);
    const statusId = wrapper.find("#loginstatusLabel");
    expect(statusId.element.id).toBe("loginstatusLabel");
    expect(statusId.element.textContent).toBe("");
  });

  it("Modify LoginComponent data and test", async () => {
    const statusId = wrapper.find("#loginstatusLabel");

    await wrapper.setData({ loginStatus: "Success" });
    await flushPromises();
    expect(statusId.element.textContent).toBe("Success");

    await wrapper.setData({ loginStatus: "Failed" });
    await flushPromises();
    expect(statusId.element.textContent).toBe("Failed");
  });

  //My testssss
  it("Check text can be entered in login fields", async () => {
    const usernameinput = wrapper.find('input[data-testid="username-input"');
    const passwordinput = wrapper.find('input[data-testid="password-input"');

    await usernameinput.setValue("user");
    await passwordinput.setValue("pass");

    await flushPromises();

    expect(usernameinput.element.value).toBe("user");
    expect(passwordinput.element.value).toBe("pass");
  });

  it("'Sign in' button trigger", async () => {
    const usernameinput = wrapper.find('input[data-testid="username-input"');
    const passwordinput = wrapper.find('input[data-testid="password-input"');
    const submitButton = wrapper.find("button");
    const statusId = wrapper.find("#loginstatusLabel");

    await usernameinput.setValue("user");
    await passwordinput.setValue("pass");
    await submitButton.trigger("click");

    await flushPromises();

    expect(statusId.element.textContent).toBe("Success");
  });

  it("Check state is updated upon succesfull login", async () => {
    const usernameinput = wrapper.find('input[data-testid="username-input"');
    const passwordinput = wrapper.find('input[data-testid="password-input"');
    const submitButton = wrapper.find("button");

    await usernameinput.setValue("user");
    await passwordinput.setValue("pass");
    await submitButton.trigger("click");

    await flushPromises();

    expect(store.state.username).toBe("user");
  });
});
