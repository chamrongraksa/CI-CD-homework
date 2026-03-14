# CI/CD Homework Submission

This document provides all required submission artifacts for the assignment.

## 1. GitHub Repository URL

- Repository: <https://github.com/chamrongraksa/CI-CD-homework.git>

Included workflow files:

- `.github/workflows/frontend-vercel.yml`
- `.github/workflows/backend-ghcr.yml`
- `.github/workflows/backend-render-cd.yml`

## 2. Live Frontend URL (Vercel)

- Frontend (public): <https://ci-cd-homework.vercel.app>

## 3. Live Backend URL + Test Endpoints (Render)

- Backend base URL: <https://cicd-homework-backend.onrender.com>
- Health endpoint: <https://cicd-homework-backend.onrender.com/api/health>
- Messages endpoint (GET): <https://cicd-homework-backend.onrender.com/api/messages>
- Messages endpoint (POST): <https://cicd-homework-backend.onrender.com/api/messages>

Example request body for `POST /api/messages`:

```json
{
  "content": "hello from homework"
}
```

Note: The root path (`/`) may show a default Spring Boot Whitelabel page because no root endpoint is defined. The assignment endpoints above are deployed and testable.

## 4. GitHub Actions Successful Workflow Runs

- Frontend CI/CD (Vercel): <https://github.com/chamrongraksa/CI-CD-homework/actions/runs/23090516715>
- Backend CI (Build & Push to GHCR): <https://github.com/chamrongraksa/CI-CD-homework/actions/runs/23090243829>
- Bonus Backend CD (Render Deploy Hook): <https://github.com/chamrongraksa/CI-CD-homework/actions/runs/23090250769>
