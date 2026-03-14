# Homework Submission

## 1. GitHub Repo URL

- Repo: <https://github.com/<your-username>/<your-repo>>

Must include these workflow files:

- .github/workflows/frontend-vercel.yml
- .github/workflows/backend-ghcr.yml
- .github/workflows/backend-render-cd.yml

## 2. Live Frontend URL (Vercel)

- Frontend URL: <https://...>

## 3. Live Backend URL + Endpoints

- Backend base URL: <https://...>
- Health endpoint: <https://.../api/health>
- Messages endpoint (GET): <https://.../api/messages>
- Messages endpoint (POST): <https://.../api/messages>

Example POST body:

```json
{
  "content": "hello from homework"
}
```

## 4. GitHub Actions Successful Run Links

- Frontend workflow run: <https://github.com/<org-or-user>/<repo>/actions/runs/...>
- Backend GHCR workflow run: <https://github.com/<org-or-user>/<repo>/actions/runs/...>
- Bonus Render CD run (optional): <https://github.com/<org-or-user>/<repo>/actions/runs/...>
