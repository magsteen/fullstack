import { flushPromises, shallowMount } from "@vue/test-utils";
import store from "@/store/index.js";
import Register from "@/components/Register.vue";

describe("Register.vue", () => {
  it("check that register component takes intended input", async () => {
    const wrapper = shallowMount(Register, {
      global: {
        mocks: {
          $store: store,
        },
      },
    });
    const usernameinput = wrapper.find('input[data-testid="username-input"');
    const emailinput = wrapper.find('input[data-testid="email-input"');
    const passwordinput = wrapper.find('input[data-testid="password-input"');

    await usernameinput.setValue("Gorilla");
    await emailinput.setValue("Monke@mail.com");
    await passwordinput.setValue("Banana");

    await flushPromises();

    expect(usernameinput.element.value).toBe("Gorilla");
    expect(emailinput.element.value).toBe("Monke@mail.com");
    expect(passwordinput.element.value).toBe("Banana");
  });

  it("Check that register button works by checking status after button trigger", async () => {
    const wrapper = shallowMount(Register, {
      global: {
        mocks: {
          $store: store,
        },
      },
    });
    const usernameinput = wrapper.find('input[data-testid="username-input"');
    const emailinput = wrapper.find('input[data-testid="email-input"');
    const passwordinput = wrapper.find('input[data-testid="password-input"');
    const isRegistered = wrapper.find('label[data-testid="status"');
    const submitButton = wrapper.find("button");

    await usernameinput.setValue("Gorilla");
    await emailinput.setValue("Monke@mail.com");
    await passwordinput.setValue("Banana");
    await submitButton.trigger("click");

    await flushPromises();

    expect(isRegistered.element.textContent).toBe("Success");
  });

  it("Check that username is saved to the vuex store", async () => {
    const wrapper = shallowMount(Register, {
      global: {
        mocks: {
          $store: store,
        },
      },
    });
    const usernameinput = wrapper.find('input[data-testid="username-input"');
    const emailinput = wrapper.find('input[data-testid="email-input"');
    const passwordinput = wrapper.find('input[data-testid="password-input"');
    const submitButton = wrapper.find("button");

    await usernameinput.setValue("Gorilla");
    await emailinput.setValue("Monke@mail.com");
    await passwordinput.setValue("Banana");
    await submitButton.trigger("click");

    await flushPromises();

    expect(store.state.username).toBe("Gorilla");
  });
});
