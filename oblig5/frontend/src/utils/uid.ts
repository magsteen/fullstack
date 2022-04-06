let nextId = 0;

export function uid(): number {
    return nextId++;
}
