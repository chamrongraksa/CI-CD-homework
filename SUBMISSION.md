# Homework Submission

## 1. GitHub Repo URL

- Repo: <https://github.com/chamrongraksa/CI-CD-homework.git>

Must include these workflow files:

- .github/workflows/frontend-vercel.yml
- .github/workflows/backend-ghcr.yml
- .github/workflows/backend-render-cd.yml

## 2. Live Frontend URL (Vercel)

- Frontend URL: <https://ci-cd-homework.vercel.app>

## 3. Live Backend URL + Endpoints

- Backend base URL: <https://cicd-homework-backend.onrender.com>
- Health endpoint: <https://cicd-homework-backend.onrender.com/api/health>
- Messages endpoint (GET): <https://cicd-homework-backend.onrender.com/api/messages>
- Messages endpoint (POST): <https://cicd-homework-backend.onrender.com/api/messages>

Example POST body:

```json
{
  "content": "hello from homework"
}
```

## 4. GitHub Actions Successful Run Links

- Frontend workflow run: <https://github.com/chamrongraksa/CI-CD-homework/actions/runs/23090516715>
- Backend GHCR workflow run: <https://github.com/chamrongraksa/CI-CD-homework/actions/runs/23090243829>
- Bonus Render CD run (optional): <https://github.com/chamrongraksa/CI-CD-homework/actions/runs/23090250769>
